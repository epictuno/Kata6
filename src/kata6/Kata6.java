/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package kata6;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.constant.ConstantDescs.NULL;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import static java.util.stream.Collectors.joining;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlElement;


public class Kata6 {


    public static void main(String[] args) throws MalformedURLException, IOException, JAXBException {
        URL url = new URL("https://www.balldontlie.io/api/v1/players?per_page=50");
        //leo la pagina 0 (default) cogiendo los primeros 50 jugadores de esa pagina
        String json = read(url);
        Gson gson = new Gson();
        JsonObject element = gson.fromJson(json, JsonObject.class);
        JsonArray arrayjson=element.get("data").getAsJsonArray();
        List<Jugador> jugadores = new ArrayList<Jugador>();
        for (int i = 0; i < arrayjson.size(); i++) {
            JsonObject obj = arrayjson.get(i).getAsJsonObject();
            jugadores.add(deserealizar(obj));
        }
        
        for (Jugador jugador : jugadores) {
            serializar(jugador);
        }
    }

    private static String read(URL url) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()))) {
            return reader.lines().collect(joining());
        }
    }

    private static Jugador deserealizar(JsonObject json) {
        String name = json.get("first_name").getAsString();
        String lastname=json.get("last_name").getAsString();
        name=name+" "+lastname;
        JsonObject Team=json.getAsJsonObject("team");
        String teamabrev = Team.get("abbreviation").getAsString();
        String team = Team.get("name").getAsString();
        String position = json.get("position").getAsString();
        Jugador jugador = new Jugador(name,teamabrev,team,position);
        if(!json.get("weight_pounds").isJsonNull()){
        int weight = json.get("weight_pounds").getAsInt();
        jugador = new Jugador(name,teamabrev,team,position,weight);
        }
        return jugador;
    }

    private static void serializar(Jugador jugador) throws JAXBException {
        JAXBContext contexto = JAXBContext.newInstance(Jugador.class);
        Marshaller marshall = contexto.createMarshaller();
        marshall.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshall.marshal(jugador, System.out);
    }
}
