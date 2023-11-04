package tn.esprit.rh.achat.service;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tn.esprit.rh.achat.entities.CategorieProduit;
import tn.esprit.rh.achat.entities.Facture;
import tn.esprit.rh.achat.repositories.CategorieProduitRepository;
import tn.esprit.rh.achat.repositories.FactureRepository;
import tn.esprit.rh.achat.services.CategorieProduitServiceImpl;
import tn.esprit.rh.achat.services.FactureServiceImpl;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.*;



public class FactureServiceImplTest {
    @InjectMocks
    public FactureServiceImpl factureServiceImpl;
    @Mock
    public FactureRepository factureRepository;
    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    public void TestAddFacture() {
        Facture facture = new Facture();

        when(factureRepository.save(facture)).thenReturn(facture);

        Facture result = factureServiceImpl.addFacture(facture);

        assertEquals(facture, result);
    }
    @Test
    void testRetrieveAllFacture() {
        // Créer une liste fictive de stocks pour simuler la réponse de la base de données
        List<Facture> factures = new ArrayList<>();
        Facture facture1 = new Facture();
        Facture facture2 = new Facture();
        factures.add(facture1);
        factures.add(facture2);

        // Configurer le mock pour que stockRepository.findAll renvoie la liste fictive de stocks
        when(factureRepository.findAll()).thenReturn(factures);


        List<Facture> result = factureServiceImpl.retrieveAllFactures();


        verify(factureRepository).findAll();


        assertEquals(factures, result);
    }

   /* @Test
    void testUpdateFacture() {

        Facture facture = new Facture();


        when(factureRepository.save(factureRepository)).thenReturn(factureRepository);

        // Appelez la méthode updateStock
        Facture result = factureServiceImpl.updateFacture(facture);

        // Vérifiez que la méthode save a été appelée avec l'objet Stock
        verify(categorieproduitRepository).save(categorieproduit);

        // Vérifiez que l'objet renvoyé par la méthode est égal à l'objet fictif
        assertEquals(categorieproduit, result);
    }*/
    @Test
    void testRetrieveProduit() {
        Long factureId = 1L; // Remplacez cette valeur par l'identifiant du stock que vous souhaitez récupérer

        // Créez un objet fictif de type Stock pour simuler la réponse de la base de données
        Facture facture = new Facture();

        // Configurez le mock pour que stockRepository.findById renvoie l'objet fictif
        when(factureRepository.findById(factureId)).thenReturn(Optional.of(facture));

        // Appelez la méthode retrieveStock
        Facture result = factureServiceImpl.retrieveFacture(factureId);

        // Vérifiez que la méthode findById a été appelée avec le bon stockId
        verify(factureRepository).findById(factureId);

        // Vérifiez que l'objet renvoyé par la méthode est égal à l'objet fictif
        assertEquals(facture, result);


    }
   /* @Test
    void testCancelFacture() {
        Long factureId = 1L;
        doNothing().when(factureRepository).deleteById(factureId);
        factureServiceImpl.deleteCategorieProduit(produitcategorieId);
        verify(categorieproduitRepository).deleteById(produitcategorieId);
    }*/

}