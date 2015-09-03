package org.pipelinemc.Pipeline.World;

import org.pipelinemc.Pipeline.World.Location;

public interface WorldBorder
{
  void reset();
  
  double getSize();
  
  void setSize(double paramDouble);
  
  void setSize(double paramDouble, long paramLong);
  
  Location getCenter();
  
  void setCenter(double paramDouble1, double paramDouble2);
  
  void setCenter(Location paramLocation);
  
  double getDamageBuffer();
  
  void setDamageBuffer(double paramDouble);
  
  double getDamageAmount();
  
  void setDamageAmount(double paramDouble);
  
  int getWarningTime();
  
  void setWarningTime(int paramInt);
  
  int getWarningDistance();
  
  void setWarningDistance(int paramInt);
}