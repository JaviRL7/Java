package Instituto;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Asignatura {
    private String denominacion;
    private int numTrimestres;
    private Set<Alumno> alumnos;

    private Map<Alumno,Float[]> notas;

    public Asignatura(String denominacion, int numTrimestres) {
        this.denominacion = denominacion;
        this.numTrimestres = numTrimestres;
        alumnos = new TreeSet<>();
        notas = new HashMap<>();
    }

    public boolean matricular(Alumno alumno) {
        notas.put(alumno, new Float[numTrimestres]);
        return alumnos.add(alumno);
    }

    public void setNota(Alumno alumno, int trimestre, float nota) {
        comprobarMatriculaAlumno(alumno);
        comprobarTrimestre(trimestre);
        notas.get(alumno)[trimestre - 1] = nota;
    }

    public Float media(Alumno alumno) {
        comprobarMatriculaAlumno(alumno);
        Float[] notasAlumno = notas.get(alumno);
        float suma = 0f;
        int numNotas = 0;

        for (int i = 0; i < notasAlumno.length; i++) {
            if (notasAlumno[i] != null) {
                suma += notasAlumno[i];
                numNotas++;
            }
        }

        if (numNotas == 0) {
            return null;
        }

        return suma / numNotas;
    }

    public void imprimirNotas() {
        Float[] notasAlumno;
        Float notaAlumno;

        for (Alumno a : notas.keySet()) {
            System.out.println(a.getNombre());
            notasAlumno = notas.get(a);

            for (int i = 0; i < notasAlumno.length; i++) {
                notaAlumno = notasAlumno[i];
                if (notaAlumno != null) {
                    System.out.println(String.format("En el trimestre %d ha sacado %f", i + 1, notaAlumno));
                }
            }
        }
    }

    public Float nota(Alumno alumno, int trimestre) {
        comprobarTrimestre(trimestre);

        if (!alumnos.contains(alumno)) {
            return null;
        }

        return notas.get(alumno)[trimestre - 1];
    }

    private void comprobarMatriculaAlumno(Alumno alumno) {
        if (!alumnos.contains(alumno)) {
            throw new IllegalArgumentException("El alumno no está matriculado de la asignatura");
        }
    }

    private void comprobarTrimestre(int trimestre) {
        if (trimestre < 0 || trimestre > numTrimestres) {
            throw new IllegalArgumentException("El trimestre no es correcto");
        }
    }
}