package com.example.accessingdatajpa;
import javax.persistence.Embeddable;


public class AllEnums {

    enum Etat{
        ETAT_OK("OK"),
        ETAT_HS("HS");

        private final String text;

        /**
         * @param text
         */
        Etat(final String text) {
            this.text = text;
        }

        /* (non-Javadoc)
         * @see java.lang.Enum#toString()
         */
        @Override
        public String toString() {
            return text;
        }
    }

    enum Sexe{
        HOMME,
        FEMME
    }

    enum Classification{
        vMoins,
        vPlus,
        vNul
    }

    enum TempJournee{
        MATIN,
        JOURNEE,
        SOIREE,
        NUIT
    }
    
}
