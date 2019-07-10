package REST;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import java.util.*;
import User.*;
import DAO.*;

@Path("userFlutter")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DataService {

    @GET
    @Path("{email}") // parameter
    public int[] getPowerfromEmail(@PathParam("email") String email) {
        int[] powerConsumption = new int[10];

        return powerConsumption;
    }
}
