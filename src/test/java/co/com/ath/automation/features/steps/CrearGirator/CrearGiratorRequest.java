package co.com.ath.automation.features.steps.CrearGirator;

import static net.serenitybdd.rest.SerenityRest.given;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import org.apache.commons.io.IOUtils;

public class CrearGiratorRequest {

    public String CrearGiratorBody() {

        try {
            String CrearGiratorBody = IOUtils.toString(
                    this.getClass().getClassLoader().getResourceAsStream(
                        "json/PagareDeceval_CrearGirador.json"),
                    StandardCharsets.UTF_8
            );
            System. out. println(CrearGiratorBody);
            return CrearGiratorBody;

        } catch (IOException e) {
            throw new RuntimeException("Error reading file");
        }
    }

    public void CrearGirator() throws IOException {
        given()
                .contentType("application/json")
                .accept("application/json")
                .body(CrearGiratorBody())
                .when().post("https://ns9orpyu6h.execute-api.sa-east-1.amazonaws.com/PRU/CrearGirador");
    }




}
