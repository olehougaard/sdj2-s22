package dk.via.exercise12_4;

public class ConsoleLogger implements Logger{
    @Override
    public void log(String txt) {
        System.out.println(txt);
    }
}
