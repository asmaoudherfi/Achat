package tn.esprit.rh.achat.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;

import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.rh.achat.entities.Reglement;
import tn.esprit.rh.achat.repositories.ReglementRepository;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)

class ReglementServiceImplTest {
    @InjectMocks
    private ReglementServiceImpl reglementService;



    @Mock
    private ReglementRepository reglementRepository;



    @Test
    void testAddReglement() {
        Reglement reglement = new Reglement();

        when(reglementRepository.save(reglement)).thenReturn(reglement);

        Reglement result = reglementService.addReglement(reglement);

        assertEquals(reglement, result);
    }
    @Test
    void testRetrieveAllReglements() {
        List<Reglement> reglements = Arrays.asList(new Reglement(), new Reglement());
        when(reglementRepository.findAll()).thenReturn(reglements);

        List<Reglement> result = reglementService.retrieveAllReglements();

        assertEquals(2, result.size());
    }
    @Test
    void testRetrieveReglement() {
        Long reglementId = 1L;
        Reglement reglement = new Reglement();
        when(reglementRepository.findById(reglementId)).thenReturn(Optional.of(reglement));

        Reglement result = reglementService.retrieveReglement(reglementId);

        assertEquals(reglement, result);
    }
    @Test
    void testRetrieveReglementByFacture() {
        Long factureId = 1L;
        List<Reglement> reglements = Arrays.asList(new Reglement(), new Reglement());
        when(reglementRepository.retrieveReglementByFacture(factureId)).thenReturn(reglements);

        List<Reglement> result = reglementService.retrieveReglementByFacture(factureId);

        assertEquals(2, result.size());
    }
    @Test
    void testGetChiffreAffaireEntreDeuxDate() {
        Date startDate = new Date();
        Date endDate = new Date();
        float chiffreAffaire = 1000.0f;
        when(reglementRepository.getChiffreAffaireEntreDeuxDate(startDate, endDate)).thenReturn(chiffreAffaire);

        float result = reglementService.getChiffreAffaireEntreDeuxDate(startDate, endDate);

        assertEquals(chiffreAffaire, result, 0.01);
    }
}
