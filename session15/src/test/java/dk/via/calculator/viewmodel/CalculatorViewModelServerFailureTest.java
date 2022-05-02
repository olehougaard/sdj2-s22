package dk.via.calculator.viewmodel;

import dk.via.calculator.model.FailingModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorViewModelServerFailureTest {

    private CalculatorViewModel viewModel;
    private StringProperty operand1;
    private StringProperty operand2;
    private StringProperty result;
    private StringProperty error;

    @BeforeEach
    void setUp() {
        viewModel = new CalculatorViewModel(new FailingModel());
        operand1 = new SimpleStringProperty("2");
        operand2 = new SimpleStringProperty("2");
        result = new SimpleStringProperty();
        error = new SimpleStringProperty();
        viewModel.bindFirst(operand1);
        viewModel.bindSecond(operand2);
        viewModel.bindResult(result);
        viewModel.bindError(error);
    }

    @Test
    public void server_failure_during_add_sets_error() {
        viewModel.add();
        assertEquals("Server communication error", error.get());
    }
    @Test
    public void server_failure_during_subtract_sets_error() {
        viewModel.subtract();
        assertEquals("Server communication error", error.get());
    }
    @Test
    public void server_failure_during_multiply_sets_error() {
        viewModel.multiply();
        assertEquals("Server communication error", error.get());
    }
    @Test
    public void server_failure_during_divide_sets_error() {
        viewModel.divide();
        assertEquals("Server communication error", error.get());
    }
}