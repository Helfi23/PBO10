/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbo10;

/**
 *
 * @author Helfi Apriliyandi F
 */
import java.util.Scanner;

public class HP {
  static boolean isClosed = false;
  static String answer;
  static Phone phoneOfChoice;

  public static void main(String[] args) {
    Phone SamsungNote9 = new Samsung();
    Phone XiaomiSlim3 = new Xiaomi();

    Scanner input = new Scanner(System.in);

    System.out.println("--------- Pilih HP ---------");
    System.out.println("1. Xiaomi Poco M3 Pro" );
    System.out.println("2. Samsung J Prime");
    System.out.println("-----------------------------");

    System.out.print("Pilih menu : ");
    answer = input.next();

    switch(answer) {
      case "1":
        phoneOfChoice = XiaomiSlim3;
        break;
      case "2":
        phoneOfChoice = SamsungNote9;
        break;
      default:
        System.out.println("Silahkan Masukan Nomor");
    }

    PhoneUser sam = new PhoneUser(phoneOfChoice);

    while(!isClosed) {
      System.out.println("--------- Main Menu ---------");
      System.out.println("1. Nyalakan Handphone");
      System.out.println("2. Matikan Handphone");
      System.out.println("3. Perbesar Volume");
      System.out.println("4. Perkecil Volume");
      System.out.println("5. Keluar Program");
      System.out.println("-----------------------------");

      System.out.print("Pilih menu : ");
      answer = input.next();

      switch(answer) {
        case "1":
          sam.turnOn();
          break;
        case "2":
          sam.turnOff();
          break;
        case "3":
          sam.makeFullVolume();
          break;
        case "4":
          sam.makeSilentVolume();
          break;
        case "5":
          isClosed = true;
          break;
        default:
          System.out.println("Silahkan Masukan Nomor");
      }
    }
  }
}


interface Phone {
  int MAX_VOLUME = 100;
  int MIN_VOLUME = 0;

  void powerOn();
  void powerOff();
  void volumeUp();
  void volumeDown();
}

class PhoneUser {
  Phone phone;

  public PhoneUser(Phone phone) {
    this.phone = phone;
  }

  void turnOn() {
    phone.powerOn();
  }

  void turnOff() {
    phone.powerOff();
  }

  void makeFullVolume() {
    phone.volumeUp();
  }

  void makeSilentVolume() {
    phone.volumeDown();
  }
}

class Samsung implements Phone {
  int volume;
  boolean isPower;

  public Samsung() {
    volume = 50;
  }

  public String getString() {
    return "Samsung";
  }

  @Override
  public void powerOn() {
    isPower = true;
    System.out.println("HP Samsung Menyala");
    System.out.println("SAMSUNG-MENYALA.mp4");
  }

  @Override
  public void powerOff() {
    isPower = false;
    System.out.println("HP Mati");
  }

  @Override
  public void volumeUp() {
    if (isPower) {
      if (volume == MAX_VOLUME) {
        System.out.println(" Volume : 100%");
      }

      else {
        volume += 5;
        System.out.println("Volume sekarang : " + getVolume() + "%");
      }

    } else {
      System.out.println("Hp Dalam Keadaan Mati");
    }
  }

  @Override
  public void volumeDown() {
    if (isPower) {
      if (volume == MIN_VOLUME) {
        System.out.println("Volume : 0%");
      }

      else {
        volume -= 5;
        System.out.println("Volume sekarang:  " + getVolume() + "%");
      }

    } else {
      System.out.println("Hp Dalam Keadaan Mati");
    }
  }

  public int getVolume() {
    return volume;
  }
}


class Xiaomi implements Phone {
  int volume;
  boolean isPower;

  public Xiaomi() {
    volume = 50;
  }

  public String getString() {
    return "Xiaomi";
  }

  @Override
  public void powerOn() {
    isPower = true;
    System.out.println("HP Xiaomi Menyala");
    System.out.println("XIAOMI MENYALA.mp4");
  }

  @Override
  public void powerOff() {
    isPower = false;
    System.out.println("HP Mati");
  }

  @Override
  public void volumeUp() {
    if (isPower) {
      if (volume == MAX_VOLUME) {
        System.out.println("Volume : 100%");
      }

      else {
        volume += 5;
        System.out.println("Volume Sekarang: " + getVolume() + "%");
      }

    } else {
      System.out.println("Hp Dalam Keadaan Mati ");
    }
  }

  @Override
  public void volumeDown() {
    if (isPower) {
      if (volume == MIN_VOLUME) {
        System.out.println("Volume : 0%");
      }

      else {
        volume -= 5;
        System.out.println("Volume Sekarang : " + getVolume() + "%");
      }

    } else {
      System.out.println("Hp Dalam Keadaan Mati");
    }
  }

  public int getVolume() {
    return volume;
  }
}
