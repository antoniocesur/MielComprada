package com.example.demo.repositorios;

import com.example.demo.modelo.EntradaMiel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface RepositorioEntradas extends JpaRepository<EntradaMiel, Long> {
    public ArrayList<EntradaMiel> findAll();

    public EntradaMiel findById(long id);
    public ArrayList<EntradaMiel> findByParaje(String paraje);
    public void deleteById(long id);
    public EntradaMiel save(EntradaMiel entradaMiel);

}
