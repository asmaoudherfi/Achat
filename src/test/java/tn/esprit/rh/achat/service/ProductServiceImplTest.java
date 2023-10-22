package tn.esprit.rh.achat.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tn.esprit.rh.achat.entities.Produit;
import tn.esprit.rh.achat.repositories.ProduitRepository;
import tn.esprit.rh.achat.services.ProduitServiceImpl;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;



public class ProductServiceImplTest {
    @InjectMocks
    public ProduitServiceImpl produitServiceImpl;
    @Mock
    public ProduitRepository produitRepository;
    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    public void TestAddProduit() {
        Produit produit = new Produit();

        when(produitRepository.save(produit)).thenReturn(produit);

        Produit result = produitServiceImpl.addProduit(produit);

        assertEquals(produit, result);
    }
}
