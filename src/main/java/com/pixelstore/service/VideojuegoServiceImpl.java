package com.pixelstore.service;

import com.pixelstore.dto.VideojuegoRequestDTO;
import com.pixelstore.dto.VideojuegoResponseDTO;
import com.pixelstore.entity.Videojuego;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
@Service
public class VideojuegoServiceImpl implements VideojuegoService{
    private final List<Videojuego> memoriaVideojuego = new ArrayList<>();
    private final AtomicLong contadorId = new AtomicLong();

    public  VideojuegoServiceImpl(){
        memoriaVideojuego.add(
          new Videojuego(
                  contadorId.incrementAndGet(),
                  "The last of us",
                  "PS5",
                  48990,
                  3

          )
        );
    }
    @Override
    public List<Videojuego> listarVideojuego(){
        return memoriaVideojuego;
    }

    @Override
    public Optional<Videojuego> buscarPorId(Long id){
        return memoriaVideojuego.stream()
                .filter(v -> v.getId().equals(id))
                .findFirst();
    }

    @Override
    public Videojuego guardarVideojuego(Videojuego videojuego){
        videojuego.setId(contadorId.incrementAndGet());
        memoriaVideojuego.add(videojuego);
        return videojuego;
    }

    @Override
    public Videojuego actualizarVideojuego(Long id, Videojuego videojuego){
        Optional<Videojuego> videojuegoEncontrado = buscarPorId(id);
        if(videojuegoEncontrado.isPresent()){
            Videojuego videojuegoExistente = videojuegoEncontrado.get();
            videojuegoExistente.setTitulo(videojuego.getTitulo());
            videojuegoExistente.setConsola(videojuego.getConsola());
            videojuegoExistente.setPrecio(videojuego.getPrecio());
            videojuegoExistente.setStock(videojuegoExistente.getStock());
            return videojuegoExistente;
        }
        return null;
    }

    @Override
    public boolean eliminarVideojuego(Long id){
        return memoriaVideojuego.removeIf(videojuego -> videojuego.getId().equals(id));
    }

}
