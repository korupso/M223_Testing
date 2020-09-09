package ch.noseryoung.uk.domainModels.auction.unitTests;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import ch.noseryoung.uk.domainModels.auction.Auction;
import ch.noseryoung.uk.domainModels.auction.AuctionRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
// @TestPropertySource("classpath:test\\resources\\application-test.properties")
@ActiveProfiles("test")
class AuctionRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private AuctionRepository auctionRepository;

    private Auction auctionToBeTestedAgainst1;
    private Auction auctionToBeTestedAgainst2;

    @BeforeEach
    void setUp() {
        auctionToBeTestedAgainst1 = new Auction().setName("TestAuction");
        auctionToBeTestedAgainst2 = new Auction().setId(2).setName("TestAuction2");
    }

    @Test
    public void NF123442_getAll_requestAllAuctions_returnsAllUsersAuctions() throws Exception {
        Assertions.assertThat(1).isEqualTo(1);

        Optional<Auction> auction1 = auctionRepository
                .findById(auctionRepository.save(auctionToBeTestedAgainst1).getId());
        Auction auction = auction1.get();

        Assertions.assertThat(auctionRepository.findAll().size()).isEqualTo(2);
        Assertions.assertThat((auctionRepository.findAll()).get(0).getName()).isEqualTo("Dennis");

    }

    @AfterEach
    void tearDown() {
    }
}