package org.procode.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.procode.app.Product;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class ProductTests {

    private Product product;

    @Mock
    private Product product2;

    @Mock
    ArrayList<String> myList;

    @BeforeEach
    void setUp(){
        product = new Product();
    }

    @Test
    @DisplayName("Increasing Mouse Device By 150")
    void testIncreasingProductPriceBy150() {

        // Arrange
        product.setName("Mouse Device");
        product.setId(342);
        product.setPrice(100);

        // Action
        product.increasePrice(150);


        // Assertions
        assertEquals(250, product.getPrice());
    }

    @Test
    @DisplayName("Decreasing Laptop Device By 2000")
    void testDecreasingProductPriceBy2000() {

        // Arrange
        product.setName("Laptop Device");
        product.setId(4556);
        product.setPrice(12000);

        // Action
        product.decreasePrice(2000);


        // Assertions
        assertEquals(10000, product.getPrice());
    }

    @Test
    void testGettingProductCatalogue() {
        when(product2.getProductCatalogue(100l)).thenReturn("1234 DJFSJFDJS"); //stub
        assertEquals("1234 DJFSJFDJS",product2.getProductCatalogue(100l));
    }

    @Test
    void testArrayListSizeIs10() {
       /* when(myList.get(0)).thenReturn("Kareem"); //stub
        when(myList.size()).thenReturn(13); *///stub
        when(myList.contains("Ahmed")).thenReturn(true); //stub

        assertTrue(myList.contains("Ahmed"));
        verify(myList,times(1)).contains("Ahmed");
    }


}
