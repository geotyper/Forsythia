package org.fleen.forsythia.app.spinner.core;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/*
 * load an appropriately sized and oriented image from a PNG file and use it for a stripe
 */
public class Stripe_Header implements Stripe{
  
  public Stripe_Header(StripeChainWithMovingViewport chain,String path){
    this.chain=chain;
    initImage(path);}

  /*
   * ################################
   * CHAIN
   * ################################
   */
  
  StripeChainWithMovingViewport chain;
  
  /*
   * ################################
   * IMAGE
   * ################################
   */
  
  BufferedImage image;
  
  private void initImage(String path){
    File f=new File(path);
    try{
      image=ImageIO.read(f);
    }catch(IOException x){
      System.out.println("exception in image init");
      x.printStackTrace();}}

  /*
   * ################################
   * GEOMETRY
   * ################################
   */
  
  public int getImageWidth(){
    return image.getWidth();}
  
  public int getImageX(){
    int 
      a=chain.indexOf(this),
      sum=0;
    for(int i=0;i<a;i++)
      sum+=chain.get(i).getImageWidth();
    return sum;}
  
}
