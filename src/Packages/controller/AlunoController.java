package Packages.controller;

import Packages.bo.Aluno;
import Packages.model.AlunoDAO;

public class AlunoController {
    public void create(Aluno aluno) {
        AlunoDAO model = new AlunoDAO();
        model.create(aluno);
    }
    public void delete(Aluno aluno) {
        AlunoDAO model = new AlunoDAO();
        model.delete(aluno);
    }

    public void update(Aluno aluno) {
        AlunoDAO model = new AlunoDAO();
        model.update(aluno);
    }
    public void read(Aluno aluno) {
        AlunoDAO model = new AlunoDAO();
        model.read(aluno);
    }
}
