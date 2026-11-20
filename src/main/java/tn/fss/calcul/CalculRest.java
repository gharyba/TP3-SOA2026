package tn.fss.calcul;

import jakarta.ws.rs.BadRequestException;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/calcul")
@Produces(MediaType.APPLICATION_JSON)
public class CalculRest {
    private final Calculatrice calculatrice = new Calculatrice();

    @GET
    @Path("/addition")
    public Operation addition(@QueryParam("a") Double a, @QueryParam("b") Double b) {
        verifier(a, b);
        return new Operation(a, b, "+", calculatrice.addition(a, b));
    }

    @GET
    @Path("/soustraction")
    public Operation soustraction(@QueryParam("a") Double a, @QueryParam("b") Double b) {
        verifier(a, b);
        return new Operation(a, b, "-", calculatrice.soustraction(a, b));
    }

    @GET
    @Path("/multiplication")
    public Operation multiplication(@QueryParam("a") Double a, @QueryParam("b") Double b) {
        verifier(a, b);
        return new Operation(a, b, "*", calculatrice.multiplication(a, b));
    }

    @GET
    @Path("/division")
    public Operation division(@QueryParam("a") Double a, @QueryParam("b") Double b) {
        verifier(a, b);
        if (b == 0) {
            throw erreur("Division par zero interdite.");
        }
        return new Operation(a, b, "/", calculatrice.division(a, b));
    }

    private void verifier(Double a, Double b) {
        if (a == null || b == null || !Double.isFinite(a) || !Double.isFinite(b)) {
            throw erreur("Les parametres a et b sont obligatoires et doivent etre finis.");
        }
    }

    private BadRequestException erreur(String message) {
        return new BadRequestException(Response.status(Response.Status.BAD_REQUEST)
                .type(MediaType.TEXT_PLAIN).entity(message).build());
    }
}
