package coder.springframework.testing.models;

import coder.springframework.testing.interfaces.IModelTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;
@SuppressWarnings("unused")
class OwnerModelTest  implements IModelTest {
    Owner owner ;
    @BeforeEach
    void setUp() {
        owner = new Owner(1L,"mike","jones") ;
    }

    @Test
    @DisplayName("Verifying Person Props")
    void ownerGroupAssertion() {
        assertAll("Test Props Set" ,
                ()-> assertEquals(1L,owner.getId()) ,
                ()-> assertEquals("mike",owner.getFirstName()) ,
                ()-> assertEquals("jones",owner.getLastName())
        );
    }

    @Test
    void findAllProductOfOwner() {
        assertThrows(
                UnsupportedOperationException.class ,
                () -> owner.getProducts()
        ) ;
    }

    @Test
    void testTimeout() {
         assertTimeout(Duration.ofMillis(1000),()-> owner.longTask() ) ;
    }

    @DisplayName("find users")
    @RepeatedTest(value=5,
            name=  RepeatedTest.DISPLAY_NAME_PLACEHOLDER + " - " +
                    RepeatedTest.CURRENT_REPETITION_PLACEHOLDER +" out of " +
                    RepeatedTest.TOTAL_REPETITIONS_PLACEHOLDER )
    public void repeatedTest() {

    }


    @ParameterizedTest()
    @DisplayName("csv test")
    @CsvSource({
            "MAR,1,2",
            "ALG,3,2",
            "EGY,4,2"
    })
    void csvSourceTest(String countryName , int num1 , int num2) {
        System.out.printf("country , num-1 , num-2 -> %s %d %d \n",countryName,num1,num2);

    }
    @ParameterizedTest()
    @DisplayName("csv test")
    //                          / relative to test package
    @CsvFileSource(resources = "/input.csv",numLinesToSkip = 1) // skip header
    void csvFileTest(String countryName , int num1 , int num2) {
        System.out.printf("country , num-1 , num-2 -> %s %d %d \n",countryName,num1,num2);

    }
}