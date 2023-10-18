package tn.esprit.rh.achat.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import tn.esprit.rh.achat.entities.Produit;
import tn.esprit.rh.achat.repositories.ProduitRepository;
import tn.esprit.rh.achat.services.ProduitServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ProductServiceImplTest {
    @Autowired
    public ProduitServiceImpl produitServiceImpl;
    @Autowired
    public ProduitRepository produitRepository;
    @Test
    public void TestAddProduit() {
        Produit produit = new Produit();
        produit.setCodeProduit("test");
        produitRepository.save(produit);
        Produit result = produitServiceImpl.addProduit(produit);
        assertEquals("test", result.getCodeProduit());
    }
}
