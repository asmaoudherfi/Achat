package tn.esprit.rh.achat;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.rh.achat.entities.Fournisseur;
import tn.esprit.rh.achat.entities.SecteurActivite;
import tn.esprit.rh.achat.repositories.DetailFournisseurRepository;
import tn.esprit.rh.achat.repositories.FournisseurRepository;
import tn.esprit.rh.achat.repositories.SecteurActiviteRepository;
import tn.esprit.rh.achat.services.FournisseurServiceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FournisseurServiceImplTest {

    @InjectMocks
    private FournisseurServiceImpl fournisseurService;

    @Mock
    private FournisseurRepository fournisseurRepository;

    @Mock
    private DetailFournisseurRepository detailFournisseurRepository;

    @Mock
    private SecteurActiviteRepository secteurActiviteRepository;

    @Before
    public void setup() {
        // Define the behavior of mock repositories here
    }

    @Test
    public void testretrieveAllFournisseurs() {
        // Create a list of Fournisseurs for testing
        List<Fournisseur> fournisseurs = new ArrayList<>();
        fournisseurs.add(new Fournisseur(/* Initialize with required data */));
        fournisseurs.add(new Fournisseur(/* Initialize with required data */));

        // Define the behavior of the mock repository
        when(fournisseurRepository.findAll()).thenReturn(fournisseurs);

        // Call the service method to test
        List<Fournisseur> result = fournisseurService.retrieveAllFournisseurs();

        // Add your assertions here to verify the result
    }

    @Test
    public void testaddFournisseur() {
        // Create a Fournisseur object for testing
        Fournisseur fournisseur = new Fournisseur(/* Initialize with required data */);

        // Define the behavior of the mock repository
        when(fournisseurRepository.save(fournisseur)).thenReturn(fournisseur);

        // Call the service method to test
        Fournisseur result = fournisseurService.addFournisseur(fournisseur);

        // Add your assertions here to verify the result
    }

    @Test
    public void testupdateFournisseur() {
        // Create a Fournisseur object for testing
        Fournisseur fournisseur = new Fournisseur(/* Initialize with required data */);

        // Define the behavior of the mock repository
        when(fournisseurRepository.save(fournisseur)).thenReturn(fournisseur);

        // Call the service method to test
        Fournisseur result = fournisseurService.updateFournisseur(fournisseur);

        // Add your assertions here to verify the result
    }

    @Test
    public void testdeleteFournisseur() {
        Long fournisseurId = 1L; // Replace with an actual ID
        // Define the behavior of the mock repository (if needed)

        // Call the service method to test
        fournisseurService.deleteFournisseur(fournisseurId);

        // Add your assertions here to verify the result
    }

    @Test
    public void testretrieveFournisseur() {
        Long fournisseurId = 1L; // Replace with an actual ID
        // Define the behavior of the mock repository (if needed)

        // Call the service method to test
        Fournisseur result = fournisseurService.retrieveFournisseur(fournisseurId);

        // Add your assertions here to verify the result
    }

}