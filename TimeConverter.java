package TimeConverter;

public class TimeConverter {
    
    public double hourstominutes(double hours) {
        return hours * 60.0;
    }

    public double minutestohours(double minutes) {
        return minutes / 60.0;
    }

    public double hourstoseconds(double hours) {
        return hours * 3600.0;
    }

    public double secondstohours(double seconds) {
        return seconds / 3600.0;
    }
}
