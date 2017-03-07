package com.tinhpt.ecommerce.entities;

import javax.persistence.*;

@Entity
@Table(name = "made_ins", schema = "ecommerce")
public class MadeIn {
    private int id;
    private String code;
    private String madeIn;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "code")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Basic
    @Column(name = "made_in")
    public String getMadeIn() {
        return madeIn;
    }

    public void setMadeIn(String madeIn) {
        this.madeIn = madeIn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MadeIn madeIn1 = (MadeIn) o;

        if (id != madeIn1.id) return false;
        if (code != null ? !code.equals(madeIn1.code) : madeIn1.code != null) return false;
        if (madeIn != null ? !madeIn.equals(madeIn1.madeIn) : madeIn1.madeIn != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (madeIn != null ? madeIn.hashCode() : 0);
        return result;
    }
}
