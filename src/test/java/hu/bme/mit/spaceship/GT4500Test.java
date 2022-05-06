package hu.bme.mit.spaceship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class GT4500Test {
  private TorpedoStore mockTS1;
  private TorpedoStore mockTS2;

  private GT4500 ship;

  @BeforeEach
  public void init(){
    mockTS1 = mock(TorpedoStore.class);
    mockTS2 = mock(TorpedoStore.class);

    this.ship = new GT4500(mockTS1, mockTS2);
  }

  @Test
  public void fireTorpedo_Single_Success(){
    // Arrange
    when(mockTS1.fire(1)).thenReturn(true);
    when(mockTS2.fire(1)).thenReturn(false);

    // Act
  
    ship.fireTorpedo(FiringMode.SINGLE);

    // Assert
    verify(mockTS1, times(1)).fire(1);
    verify(mockTS2, times(1)).fire(1);
  }

  @Test
  public void fireTorpedo_All_Success(){
    // Arrange
    when(mockTS1.fire(2)).thenReturn(true);
    when(mockTS2.fire(2)).thenReturn(true);

    // Act
    ship.fireTorpedo(FiringMode.ALL);

    // Assert
    verify(mockTS1, times(1)).fire(2);
    verify(mockTS1, times(1)).fire(1);
  }

}
