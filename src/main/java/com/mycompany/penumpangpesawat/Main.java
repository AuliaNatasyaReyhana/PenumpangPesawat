/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.penumpangpesawat;


class Passenger {
    String name;
    Passenger next;

    public Passenger(String name) {
        this.name = name;
        this.next = null;
    }
}

class Flight {
    private Passenger head;

    public Flight() {
        this.head = null;
    }

    // Method untuk menambah penumpang di akhir daftar
    public void addPassenger(String name) {
        Passenger newPassenger = new Passenger(name);
        if (head == null) {
            head = newPassenger;
        } else {
            Passenger current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newPassenger;
        }
    }

    // Method untuk menghapus penumpang berdasarkan nama
    public void removePassenger(String name) {
        if (head == null) {
            System.out.println("Daftar penumpang kosong.");
            return;
        }

        if (head.name.equals(name)) {
            head = head.next;
            System.out.println(name + " telah dihapus dari daftar.");
            return;
        }

        Passenger current = head;
        Passenger previous = null;

        while (current != null && !current.name.equals(name)) {
            previous = current;
            current = current.next;
        }

        if (current == null) {
            System.out.println(name + " tidak ditemukan.");
        } else {
            previous.next = current.next;
            System.out.println(name + " telah dihapus dari daftar.");
        }
    }

    // Method untuk menampilkan semua penumpang
    public void displayPassengers() {
        if (head == null) {
            System.out.println("Daftar penumpang kosong.");
        } else {
            Passenger current = head;
            while (current != null) {
                System.out.println(current.name);
                current = current.next;
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Flight flight = new Flight();
        flight.addPassenger("Alice");
        flight.addPassenger("Bob");
        flight.addPassenger("Charlie");

        flight.displayPassengers();  // Menampilkan semua penumpang

        flight.removePassenger("Bob");  // Menghapus penumpang Bob
        flight.displayPassengers();  // Menampilkan semua penumpang setelah penghapusan
    }
}
