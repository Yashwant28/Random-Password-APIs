package com.stark.tech.resource;

import com.stark.tech.exception.StarkTechException;
import com.stark.tech.model.ExceptionModel;
import com.stark.tech.model.Password;
import com.stark.tech.service.RandomPasswordGeneratorService;

import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Produces("application/json")
@Path("/generate-password")
public class RandomPasswordGeneratorResource {

    private RandomPasswordGeneratorService randomPasswordGeneratorService;

    @Inject
    public RandomPasswordGeneratorResource(RandomPasswordGeneratorService randomPasswordGeneratorService) {
        this.randomPasswordGeneratorService = randomPasswordGeneratorService;
    }

    @GET
    public Response generateRandomPassword(@QueryParam("passwordLength") @NotNull Integer passwordLength, @QueryParam("passwordType") String passwordType) {
        Password password;
        try {
            password = randomPasswordGeneratorService.generateRandomPassword(passwordLength, passwordType);
        } catch (StarkTechException starkTechException) {
            ExceptionModel exceptionModel = starkTechException.getExceptionModel();
            return Response.status(Response.Status.BAD_REQUEST).entity(exceptionModel).build();
        } catch (Exception exception) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(exception).build();
        }
        return Response.status(Response.Status.OK).entity(password).build();
    }
}
