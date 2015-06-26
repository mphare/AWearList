package com.mphare.awearlist;

/**
 * Created by mphare on 6/25/2015.
 */
public class CustomBean
{
  Integer icon;
  String  label;
  String  description;

  public CustomBean(Integer icon, String label, String description)
  {
    this.icon = icon;
    this.label = label;
    this.description = description;
  }

  public String getLabel()
  {
    return label;
  }

  public void setLabel(String label)
  {
    this.label = label;
  }

  public Integer getIcon()
  {
    return icon;
  }

  public void setIcon(Integer icon)
  {
    this.icon = icon;
  }

  public String getDescription()
  {
    return description;
  }

  public void setDescription(String description)
  {
    this.description = description;
  }

}
