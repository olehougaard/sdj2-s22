package dk.via.calculator.viewmodel;

import dk.via.calculator.model.FakeModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorViewModelTest {

    private CalculatorViewModel viewModel;
    private StringProperty operand1;
    private StringProperty operand2;
    private StringProperty result;
    private StringProperty error;

    @BeforeEach
    void setUp() {
        viewModel = new CalculatorViewModel(new FakeModel());
        operand1 = new SimpleStringProperty();
        operand2 = new SimpleStringProperty();
        result = new SimpleStringProperty();
        error = new SimpleStringProperty();
        viewModel.bindFirst(operand1);
        viewModel.bindSecond(operand2);
        viewModel.bindResult(result);
        viewModel.bindError(error);
    }

    // Zero - testing a new object.
    @Test
    public void a_new_view_model_is_blank() {
        assertEquals("0", operand1.get());
        assertEquals("0", operand2.get());
        assertEquals("", result.get());
        assertEquals("", error.get());
    }

    @Test
    public void setting_operands_doesnt_change_result_or_error() {
        operand1.setValue("7");
        operand2.setValue("2");
        assertEquals("", result.get());
        assertEquals("", error.get());
    }

    @Test
    public void add_adds_the_operands() {
        operand1.setValue("7");
        operand2.setValue("2");
        viewModel.add();
        assertEquals(String.format("%f + %f = %f", 7.0, 2.0, 9.0), result.get());
        assertEquals("", error.get());
    }

    @Test
    public void subtract_subtracts_the_operands() {
        operand1.setValue("7");
        operand2.setValue("2");
        viewModel.subtract();
        assertEquals(String.format("%f - %f = %f", 7.0, 2.0, 5.0), result.get());
        assertEquals("", error.get());
    }

    @Test
    public void multiply_multiplies_the_operands() {
        operand1.setValue("7");
        operand2.setValue("2");
        viewModel.multiply();
        assertEquals(String.format("%f * %f = %f", 7.0, 2.0, 14.0), result.get());
        assertEquals("", error.get());
    }

    @Test
    public void divide_divides_the_operands() {
        operand1.setValue("7");
        operand2.setValue("2");
        viewModel.divide();
        assertEquals(String.format("%f / %f = %f", 7.0, 2.0, 3.5), result.get());
        assertEquals("", error.get());
    }

    @Test
    public void division_by_zero_gives_an_error() {
        operand1.setValue("7");
        operand2.setValue("0");
        viewModel.divide();
        assertEquals("", result.get());
        assertEquals("Division by zero", error.get());
    }

    @Test
    public void errors_clear_results() {
        operand1.setValue("7");
        operand2.setValue("0");
        viewModel.add();
        viewModel.divide();
        assertEquals("", result.get());
    }

    @Test
    public void errors_do_not_clear_operands() {
        operand1.setValue("7");
        operand2.setValue("0");
        viewModel.add();
        viewModel.divide();
        assertEquals("7", operand1.get());
        assertEquals("0", operand2.get());
    }

    @Test
    public void successful_add_clears_errors() {
        operand1.setValue("7");
        operand2.setValue("0");
        viewModel.divide();
        viewModel.add();
        assertEquals("", error.get());
    }

    @Test
    public void successful_subtract_clears_errors() {
        operand1.setValue("7");
        operand2.setValue("0");
        viewModel.divide();
        viewModel.subtract();
        assertEquals("", error.get());
    }

    @Test
    public void successful_multiply_clears_errors() {
        operand1.setValue("7");
        operand2.setValue("0");
        viewModel.divide();
        viewModel.multiply();
        assertEquals("", error.get());
    }

    @Test
    public void successful_divide_clears_errors() {
        operand1.setValue("7");
        operand2.setValue("0");
        viewModel.divide();
        operand2.setValue("1");
        viewModel.divide();
        assertEquals("", error.get());
    }

    @Test
    public void result_cannot_be_set_outside_viewmodel() {
        assertThrows(RuntimeException.class, () -> result.set("23"));
    }

    @Test
    public void error_cannot_be_set_outside_viewmodel() {
        assertThrows(RuntimeException.class, () -> error.set("Error"));
    }
}