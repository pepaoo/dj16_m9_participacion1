package mx.unam.dgtic.m9_participacion1.controller;

import mx.unam.dgtic.m9_participacion1.model.Disco;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/discos")
public class DiscoController {

    private final Map<Integer, Disco> discos;

    public DiscoController() {
//        discos = Map.of(
//                1, new Disco(1, "Fate in the future", "Louis Tomlinson", LocalDate.of(2023, 9, 15)),
//                2, new Disco(2, "The Last of Us", "Gustavo Santaolalla", LocalDate.of(2023, 1, 15)),
//                3, new Disco(3, "The Dark Side of the Moon", "Pink Floyd", LocalDate.of(1973, 3, 1))
//        );
        discos = new HashMap<>();
        discos.put(1, new Disco(1, "Fate in the future", "Louis Tomlinson", LocalDate.of(2023, 9, 15)));
        discos.put(2, new Disco(2, "The Last of Us", "Gustavo Santaolalla", LocalDate.of(2023, 1, 15)));
        discos.put(3, new Disco(3, "The Dark Side of the Moon", "Pink Floyd", LocalDate.of(1973, 3, 1)));
        discos.put(4, new Disco(4, "The Wall", "Pink Floyd", LocalDate.of(1979, 11, 30)));
    }

    @GetMapping("ping")
    public String ping() {
        return "OK";
    }

    @GetMapping(value = "", headers = {"Accept=application/json"},
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<Integer, Disco>> getDiscos() {
        return new ResponseEntity<>(discos, HttpStatus.OK);
    }


    @GetMapping("{id}")
    public ResponseEntity<Disco> getDisco(@PathVariable Integer id) {
        //return discos.get(id);
        Disco disco = discos.get(id);
        return disco == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(disco);
    }

    @PostMapping(produces =  MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Disco> addDisco(@RequestBody Disco disco) {
        // Simular la generación de un nuevo ID
        int id = 1;
        while (discos.containsKey(id)) id++;
        disco.setId(id);
        discos.put(disco.getId(), disco);
        //return disco;
        return ResponseEntity.status(HttpStatus.CREATED).body(disco);
    }

    @PutMapping("{id}")
    public ResponseEntity<Disco> updateDisco(@PathVariable Integer id, @RequestBody Disco disco) {
        if (discos.containsKey(id)) {
            disco.setId(id);
            discos.put(id, disco);
            return ResponseEntity.ok(disco);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping(value = "{id}", produces =   MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Disco> patchDisco(@PathVariable Integer id, @RequestBody Disco disco) {
        Disco discoActual = discos.get(id); // Recuperar de la base de datos el disco actual
        if (discoActual == null) {
            return ResponseEntity.notFound().build();
        }
        if (disco.getArtista() != null) discoActual.setArtista(disco.getArtista());
        if (disco.getTitulo() != null) discoActual.setTitulo(disco.getTitulo());
        if (disco.getAnioLanzamiento() != null) discoActual.setAnioLanzamiento(disco.getAnioLanzamiento());
        discos.replace(id, discoActual);
        return ResponseEntity.ok(discoActual);
    }

    @DeleteMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Disco> deleteDisco(@PathVariable Integer id) {
        if (discos.containsKey(id)) {
            discos.remove(id);
            return ResponseEntity.noContent().build(); // 204
        } else {
            return ResponseEntity.notFound().build(); // 404
        }
    }

    @GetMapping(value = "equipo", headers = {"Accept=application/json"},
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String> getIntegrantesDelEquipo() {
        return List.of("Samantha Aislinn Gutiérrez Olvera", "Hugo Enrique Canizal Duarte"
                , "Christian Ariel Palacios Hernández", "José Luis Angulo Cabello");
    }

}
