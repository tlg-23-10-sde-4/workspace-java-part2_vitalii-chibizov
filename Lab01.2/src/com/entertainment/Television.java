package com.entertainment;

import java.util.List;
import java.util.Objects;

public class Television
        implements Comparable<Television> {
    private String brand = "Alien brand";
    private int volume = 1;
    private Tuner tuner = new Tuner();

    public Television() {
    }

    public Television(String brand) {
        setBrand(brand);
    }

    public Television(String brand, int volume) {
        this(brand);
        setVolume(volume);
    }


    public static void dump(List<Television> tvs) {
        for (Television tv : tvs) {
            System.out.println(tv);
        }
    }


    public String getBrand() {
        return this.brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getVolume() {
        return this.volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getCurrentChannel() {
        return tuner.getChannel();
    }

    public void changeChannel(int channel) {
        tuner.setChannel(channel);
    }

    @Override
    public String toString() {
        return String.format("%s brand is %s, volume is %s, current channel is %s",
                getClass().getSimpleName(), getBrand(), getVolume(), getCurrentChannel());
    }

/*    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        // proceed only if obj is really referencing a Television object
        if (obj instanceof Television) {
            // safely downcast 'obj' to more specific reference type Television
            Television other = (Television) obj;

            // do the check: business equality is defined by brand and volume being the same
            result = this.getBrand().equals(other.getBrand()) &&
                    this.getVolume() == other.getVolume();
        }
        return result;
    }*/

    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        if (obj instanceof Television) {
            Television other = (Television) obj;
            result = Objects.equals(this.getBrand(), other.getBrand()) &&
                    Objects.equals(this.getVolume(), other.getVolume());
        }
        return result;
    }
    /* if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

    Television that = (Television) obj;

        if (volume != that.volume) return false;
        return brand != null ? brand.equals(that.brand) : that.brand == null;*/

    @Override
    public int hashCode() {
        return Objects.hash(getBrand(), getVolume());
       /* int result = brand != null ? brand.hashCode() : 0;
        result = 31 * result + volume;
        return result;*/
    }

    @Override
    public int compareTo(Television other) {
        return this.getBrand().compareTo(other.getBrand());
    }
}