package com.coder.Java;

import java.util.Objects;

public class Pessoa {
    private String nome;
    private String lastName;
    private Integer idade;
    private String email;

    private Pessoa(String nome, String lastName, Integer idade, String email) {
        this.nome = nome;
        this.lastName = lastName;
        this.idade = idade;
        this.email = email;
    }

    public static class PessoaBuilder {
        private String nome;
        private String lastName;
        private Integer idade;
        private String email;

        public PessoaBuilder() {
        }

        public PessoaBuilder nome(String nome) {
            this.nome = nome;
            return this;
        }

        public PessoaBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public PessoaBuilder idade(Integer idade) {
            this.idade = idade;
            return this;
        }

        public PessoaBuilder email(String email) {
            this.email = email;
            return this;
        }

        public Pessoa build() {
            if (nome == null) {
                throw new IllegalArgumentException();
            }
            return new Pessoa(nome, lastName, idade, email);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pessoa)) return false;
        Pessoa pessoa = (Pessoa) o;
        return Objects.equals(email, pessoa.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getIdade() {
        return idade;
    }
}
