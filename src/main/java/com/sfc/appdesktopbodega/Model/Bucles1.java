package com.sfc.appdesktopbodega.Model;

import javax.swing.*;

public class Bucles1 {

        public static void main(String[] args) {

          String pass="hola";
          String user="h";
          int timer=0;
            user=JOptionPane.showInputDialog("Introduce la usuario");
            pass=JOptionPane.showInputDialog("Introduce la contraseña");
                while(!user.equals("h") && !pass.equals("hola" ) && timer <3) {

                    if (user.equals("h") && pass.equals("hola")) {
                        System.out.println("Ingreso");
                    }
                    else {

                        if (!user.equals("h") || !pass.equals("hola")) {
                            timer++;
                            System.out.println("Incorrecto");
                            user=JOptionPane.showInputDialog("Introduce la usuario");
                            pass=JOptionPane.showInputDialog("Introduce la contraseña");

                            if (timer == 3) {
                                System.out.println("Bloqueado");

                            }

                        }


                    }

                }
        }


}
