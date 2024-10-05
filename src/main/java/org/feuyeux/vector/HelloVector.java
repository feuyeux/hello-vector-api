package org.feuyeux.vector;

import jdk.incubator.vector.FloatVector;
import jdk.incubator.vector.VectorSpecies;

public class HelloVector {
  static final VectorSpecies<Float> SPECIES = FloatVector.SPECIES_PREFERRED;

  void scalarComputation(float[] a, float[] b, float[] c) {
    for (int i = 0; i < a.length; i++) {
      c[i] = (a[i] * a[i] + b[i] * b[i]) * -1.0f;
    }
  }

  void vectorComputation(float[] a, float[] b, float[] c) {
    int i = 0;
    int upperBound = SPECIES.loopBound(a.length);
    for (; i < upperBound; i += SPECIES.length()) {
      var va = FloatVector.fromArray(SPECIES, a, i);
      var vb = FloatVector.fromArray(SPECIES, b, i);
      var vc = va.mul(va).add(vb.mul(vb)).neg();
      vc.intoArray(c, i);
    }
    for (; i < a.length; i++) {
      c[i] = (a[i] * a[i] + b[i] * b[i]) * -1.0f;
    }
  }

  void vectorComputationII(float[] a, float[] b, float[] c) {
    for (int i = 0; i < a.length; i += SPECIES.length()) {
      var m = SPECIES.indexInRange(i, a.length);
      var va = FloatVector.fromArray(SPECIES, a, i, m);
      var vb = FloatVector.fromArray(SPECIES, b, i, m);
      var vc = va.mul(va).add(vb.mul(vb)).neg();
      vc.intoArray(c, i, m);
    }
  }

  static int _1B = 1_000_000_000;
  static int _2B = 2_000_000_000;

  public static void main(String[] args) {
    HelloVector hv = new HelloVector();
    int size = _2B;
    float[] a = new float[size];
    float[] b = new float[size];
    float[] c = new float[size];

    for (int i = 0; i < size; i++) {
      a[i] = (float) Math.random();
      b[i] = (float) Math.random();
    }

    long startTime = System.currentTimeMillis();
    hv.scalarComputation(a, b, c);
    long endTime = System.currentTimeMillis();
    System.out.println((endTime - startTime) + " ms");

    startTime = System.currentTimeMillis();
    hv.vectorComputation(a, b, c);
    endTime = System.currentTimeMillis();
    System.out.println((endTime - startTime) + " ms");

    startTime = System.currentTimeMillis();
    hv.vectorComputationII(a, b, c);
    endTime = System.currentTimeMillis();
    System.out.println((endTime - startTime) + " ms");
  }
}
