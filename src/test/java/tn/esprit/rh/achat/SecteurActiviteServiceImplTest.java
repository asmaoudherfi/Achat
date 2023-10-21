package tn.esprit.rh.achat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tn.esprit.rh.achat.entities.SecteurActivite;

import tn.esprit.rh.achat.repositories.SecteurActiviteRepository;
import tn.esprit.rh.achat.services.SecteurActiviteServiceImpl;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class SecteurActiviteServiceImplTest {

    @InjectMocks
    private SecteurActiviteServiceImpl secteurActiviteService;

    @Mock
    private SecteurActiviteRepository secteurActiviteRepository;
    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testaddSecteurActivite() {
        SecteurActivite secteurActivite = new SecteurActivite();

        // Configurer le mock pour que reglementRepository.save renvoie le Reglement que vous avez créé
        when(secteurActiviteRepository.save(secteurActivite)).thenReturn(secteurActivite);

        SecteurActivite result = secteurActiviteService.addSecteurActivite(secteurActivite);

        assertEquals(secteurActivite, result);
    }
    @Test
    public void testupdateSecteurActivite() {
        SecteurActivite secteurActivite = new SecteurActivite();
        when(secteurActiviteRepository.save(secteurActivite)).thenReturn(secteurActivite);

        SecteurActivite updatedSecteurActivite = secteurActiviteService.updateSecteurActivite(secteurActivite);

        assertNotNull(updatedSecteurActivite);
    }
    @Test
    void testDeleteSecteurActivite() {
        Long stockId = 1L;
        doNothing().when(secteurActiviteRepository).deleteById(stockId);
        secteurActiviteService.deleteSecteurActivite(stockId);
        verify(secteurActiviteRepository).deleteById(stockId);
    }

    @Test
    public void testretrieveSecteurActivite() {
        Long id = 1L;
        SecteurActivite secteurActivite = new SecteurActivite();
        when(secteurActiviteRepository.findById(id)).thenReturn(Optional.of(secteurActivite));

        SecteurActivite  retrievedSecteurActivite  = secteurActiviteService.retrieveSecteurActivite(id);

        assertNotNull(retrievedSecteurActivite );
    }
    @Test
    public void testretrieveAllSecteurActivite () {
        when(secteurActiviteRepository.findAll()).thenReturn(Arrays.asList(new SecteurActivite (), new SecteurActivite()));

        List<SecteurActivite > secteurActivite  = secteurActiviteService.retrieveAllSecteurActivite();

        assertEquals(2, secteurActivite .size());
    }

}
