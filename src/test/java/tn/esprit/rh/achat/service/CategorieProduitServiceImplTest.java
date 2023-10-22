package tn.esprit.rh.achat.service;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tn.esprit.rh.achat.entities.CategorieProduit;
import tn.esprit.rh.achat.entities.Produit;
import tn.esprit.rh.achat.repositories.CategorieProduitRepository;
import tn.esprit.rh.achat.repositories.ProduitRepository;
import tn.esprit.rh.achat.services.CategorieProduitServiceImpl;
import tn.esprit.rh.achat.services.ProduitServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.*;



public class CategorieProduitServiceImplTest {
    @InjectMocks
    public CategorieProduitServiceImpl categorieproduitServiceImpl;
    @Mock
    public CategorieProduitRepository categorieproduitRepository;
    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    public void TestAddCategorieProduit() {
        CategorieProduit categorieproduit = new CategorieProduit();

        when(categorieproduitRepository.save(categorieproduit)).thenReturn(categorieproduit);

        CategorieProduit result = categorieproduitServiceImpl.addCategorieProduit(categorieproduit);

        assertEquals(categorieproduit, result);
    }
    @Test
    void testRetrieveAllCategorieProduits() {
        // Créer une liste fictive de stocks pour simuler la réponse de la base de données
        List<CategorieProduit> categorieproduits = new ArrayList<>();
        CategorieProduit categorieProduit1 = new CategorieProduit();
        CategorieProduit categorieProduit2 = new CategorieProduit();
        categorieproduits.add(categorieProduit1);
        categorieproduits.add(categorieProduit2);

        // Configurer le mock pour que stockRepository.findAll renvoie la liste fictive de stocks
        when(categorieproduitRepository.findAll()).thenReturn(categorieproduits);


        List<CategorieProduit> result = categorieproduitServiceImpl.retrieveAllCategorieProduits();


        verify(categorieproduitRepository).findAll();


        assertEquals(categorieproduits, result);
    }

    @Test
    void testUpdateCategorieProduit() {

        CategorieProduit categorieproduit = new CategorieProduit();


        when(categorieproduitRepository.save(categorieproduit)).thenReturn(categorieproduit);

        // Appelez la méthode updateStock
        CategorieProduit result = categorieproduitServiceImpl.updateCategorieProduit(categorieproduit);

        // Vérifiez que la méthode save a été appelée avec l'objet Stock
        verify(categorieproduitRepository).save(categorieproduit);

        // Vérifiez que l'objet renvoyé par la méthode est égal à l'objet fictif
        assertEquals(categorieproduit, result);
    }
    @Test
    void testRetrieveProduit() {
        Long produitcategorieId = 1L; // Remplacez cette valeur par l'identifiant du stock que vous souhaitez récupérer

        // Créez un objet fictif de type Stock pour simuler la réponse de la base de données
        CategorieProduit categorieproduit = new CategorieProduit();

        // Configurez le mock pour que stockRepository.findById renvoie l'objet fictif
        when(categorieproduitRepository.findById(produitcategorieId)).thenReturn(Optional.of(categorieproduit));

        // Appelez la méthode retrieveStock
        CategorieProduit result = categorieproduitServiceImpl.retrieveCategorieProduit(produitcategorieId);

        // Vérifiez que la méthode findById a été appelée avec le bon stockId
        verify(categorieproduitRepository).findById(produitcategorieId);

        // Vérifiez que l'objet renvoyé par la méthode est égal à l'objet fictif
        assertEquals(categorieproduit, result);


    }
    @Test
    void testDeleteProduit() {
        Long produitcategorieId = 1L;
        doNothing().when(categorieproduitRepository).deleteById(produitcategorieId);
        categorieproduitServiceImpl.deleteCategorieProduit(produitcategorieId);
        verify(categorieproduitRepository).deleteById(produitcategorieId);
    }

}
