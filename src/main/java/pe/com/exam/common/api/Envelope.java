package pe.com.crehana.common.api;

import java.util.ArrayList;
import java.util.List;

public class Envelope {

    Object result;
    List<Error> errors;

    private Envelope(Object result, List<Error> errors) {
        this.result = result;
        this.errors = errors;
    }

    public static Envelope ok(Object result)
    {
        return new Envelope(result, new ArrayList<Error>());
    }

    public static Envelope error(List<Error> errors)
    {
        if (errors == null) errors = new ArrayList<>();
        return new Envelope(null, errors);
    }

    public static Envelope serverError()
    {
        List<Error> errors = new ArrayList<Error>();
        Error error = new Error("Internal Server Error", null);
        errors.add(error);
        return new Envelope(null, errors);
    }

    public static Envelope notFound()
    {
        List<Error> errors = new ArrayList<Error>();
        Error error = new Error("Entity not found", null);
        errors.add(error);
        return new Envelope(null, errors);
    }

}
