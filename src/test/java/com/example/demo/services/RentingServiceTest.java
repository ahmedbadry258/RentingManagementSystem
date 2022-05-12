package com.example.demo.services;

import com.example.demo.models.Car;
import com.example.demo.models.Renting;
import com.example.demo.repositories.RentingRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
//@ExtendWith(MockitoExtension.class)
class RentingServiceTest {



    @InjectMocks
    private RentingService rentingService;
    @Mock
    private CarService carService= Mockito.mock(CarService.class);

    private RentingRepository rentingRepository=Mockito.mock(RentingRepository.class);
    private List<Renting> rentings;
    Renting renting1;
    Renting renting2;
    private  List<String> spyOnList = Mockito.spy(new ArrayList<>());

    @BeforeAll
   static void beforeAll(){
        System.out.println("Start Tests");
    }
    @AfterAll
    static void afterAll(){
        System.out.println("end Tests");
    }
    @BeforeEach
    void setup(){
        rentingService=new RentingService(carService,rentingRepository);
        rentings=new ArrayList<>();
        renting1=new Renting(1l, LocalDate.of(2022,3,5),"ali",new Car(2,"bmw"));
        renting2 =new Renting(2l, LocalDate.of(2022,3,1),"aaa",new Car(18,"abc"));

    }
    @Test
    @DisplayName("Test findAll Renting")
    public void findAllRentingTest(){
        rentings.add(renting1);rentings.add(renting2);
        Mockito.when(rentingRepository.findAll()).thenReturn(rentings);
        assertAll(() ->assertTrue(rentingService.findAll().contains(renting1)),
                ()->assertEquals(2,rentingService.findAll().size()),
                ()->assertEquals(2,rentings.size())
                );
    }


    @Test
    public void addRentingTest(){

    Mockito.doThrow(new RuntimeException("something wrong is happend")).when(rentingRepository).save(renting1);
    RuntimeException runtimeException=assertThrows(RuntimeException.class,()->rentingService.saveRenting(renting1));
    assertEquals("something wrong is happend",runtimeException.getMessage());
    }

    List<String> myList = Mockito.spy(ArrayList.class);

    @Test
    public void usingSpyAnnotation() {
        myList.add("Hello, This is LambdaTest");
        myList.add("Hello");
        Mockito.verify(myList).add("Hello");
        Mockito.verify(myList).add("Hello, This is LambdaTest");
        assertEquals(2, myList.size());
    }

}