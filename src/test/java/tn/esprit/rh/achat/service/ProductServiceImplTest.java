package tn.esprit.rh.achat.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tn.esprit.rh.achat.entities.Produit;
import tn.esprit.rh.achat.repositories.ProduitRepository;
import tn.esprit.rh.achat.services.ProduitServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.*;





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
    @Test
    void testDeleteProduit() {
        Long produitId = 1L;
        doNothing().when(produitRepository).deleteById(produitId);
        produitServiceImpl.deleteProduit(produitId);
        verify(produitRepository).deleteById(produitId);
    }
    @Test
    void testRetrieveAllProduits() {
        // Créer une liste fictive de stocks pour simuler la réponse de la base de données
        List<Produit> produits = new ArrayList<>();
        Produit produit1 = new Produit();
        Produit produit2 = new Produit();
        produits.add(produit1);
        produits.add(produit2);

        // Configurer le mock pour que stockRepository.findAll renvoie la liste fictive de stocks
        when(produitRepository.findAll()).thenReturn(produits);


        List<Produit> result = produitServiceImpl.retrieveAllProduits();


        verify(produitRepository).findAll();


        assertEquals(produits, result);
    }
    @Test
    void testUpdateProduit() {

        Produit produit = new Produit();


        when(produitRepository.save(produit)).thenReturn(produit);

        // Appelez la méthode updateStock
        Produit result = produitServiceImpl.updateProduit(produit);

        // Vérifiez que la méthode save a été appelée avec l'objet Stock
        verify(produitRepository).save(produit);

        // Vérifiez que l'objet renvoyé par la méthode est égal à l'objet fictif
        assertEquals(produit, result);
    }
    @Test
    void testRetrieveProduit() {
        Long produitId = 1L; // Remplacez cette valeur par l'identifiant du stock que vous souhaitez récupérer

        // Créez un objet fictif de type Stock pour simuler la réponse de la base de données
        Produit produit = new Produit();

        // Configurez le mock pour que stockRepository.findById renvoie l'objet fictif
        when(produitRepository.findById(produitId)).thenReturn(Optional.of(produit));

        // Appelez la méthode retrieveStock
        Produit result = produitServiceImpl.retrieveProduit(produitId);

        // Vérifiez que la méthode findById a été appelée avec le bon stockId
        verify(produitRepository).findById(produitId);

        // Vérifiez que l'objet renvoyé par la méthode est égal à l'objet fictif
        assertEquals(produit, result);


    }


}
