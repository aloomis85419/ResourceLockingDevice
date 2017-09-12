//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import Device.a;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Device {
    public static final int DEFAULT_SIZE = 4;
    public static final int DEFAULT_PEEKS = 2;
    public static final char VALUE_TRUE = 'T';
    public static final char VALUE_FALSE = 'F';
    private int a;
    private int b;
    private boolean[] a;
    private a a;
    private CharSequence a;

    public Device() {
        this(4, 2);
    }

    public Device(int size, int bitsPerPeek) {
        this.a = 4;
        this.b = 2;
        this.a = new boolean[this.a];
        this.a = size;
        this.b = bitsPerPeek;
        this.a = new boolean[this.a];

        for (size = 0; size < this.a; ++size) {
            this.a[size] = Math.random() >= 0.5D;
        }

        this.a = a.a;
    }

    public Device(boolean[] initialBits, int bitsPerPeek) {
        this.a = 4;
        this.b = 2;
        this.a = new boolean[this.a];
        this.a = initialBits.length;
        this.b = bitsPerPeek;
        this.a = Arrays.copyOf(initialBits, this.a);
        this.a = a.a;
    }

    public boolean spin() {
        if (this.a == a.a || this.a == a.b || this.a == a.c) {
            for (int var1 = (int) (Math.random() * (double) this.a); var1 > 0; --var1) {
                Device var2 = this;
                boolean var3 = this.a[0];

                for (int var4 = 1; var4 < var2.a; ++var4) {
                    var2.a[var4 - 1] = var2.a[var4];
                }

                var2.a[var2.a - 1] = var3;
            }

            this.a = a.a;
        }

        return !IntStream.range(0, this.a.length).mapToObj((var1) -> {
            return Boolean.valueOf(this.a[var1]);
        }).anyMatch((var0) -> {
            return !var0.booleanValue();
        }) || !IntStream.range(0, this.a.length).mapToObj((var1) -> {
            return Boolean.valueOf(this.a[var1]);
        }).anyMatch((var0) -> {
            return var0.booleanValue();
        });
    }

    public CharSequence peek(CharSequence pattern) {
        char[] var2 = new char[this.a];
        if (this.a == a.a && pattern.length() == this.a && (long) this.b >= pattern.chars().filter((var0) -> {
            return var0 == 63;
        }).count()) {
            this.a = pattern;
            this.a = a.b;

            for (int var3 = 0; var3 < this.a; ++var3) {
                if (pattern.charAt(var3) == 63) {
                    var2[var3] = (char) (this.a[var3] ? 84 : 70);
                } else {
                    var2[var3] = pattern.charAt(var3);
                }
            }
        }

        return new String(var2);
    }

    public void poke(CharSequence pattern) {
        if (this.a == a.b && pattern.length() == this.a && this.a != null && this.a.length() == this.a && (long) this.b >= this.a.chars().filter((var0) -> {
            return var0 == 63;
        }).count()) {
            this.a = a.c;

            for (int var2 = 0; var2 < this.a; ++var2) {
                if (this.a.charAt(var2) == 63) {
                    char var3;
                    if ((var3 = pattern.charAt(var2)) == 84) {
                        this.a[var2] = true;
                    } else if (var3 == 70) {
                        this.a[var2] = false;
                    }
                }
            }
        }

    }

    public String toString() {
        return "Device state: " + this.a;
    }
}
