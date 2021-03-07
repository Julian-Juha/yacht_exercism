class Yacht {

    // variables
    int[] m_dice;
    YachtCategory m_yachtCategory;

    // constructor
    Yacht(int[] dice, YachtCategory yachtCategory) {
        m_dice = dice;
        m_yachtCategory = yachtCategory;
    }


    int score() {

        switch (m_yachtCategory) {

            case YACHT:

                // check if really yacht
                for (int i = 0; i < m_dice.length - 1; i++) {
                    if (m_dice[i] != m_dice[i + 1]) {
                        return 0;
                    }
                }
                return 50;

            case ONES:
                return counter(1);

            case TWOS:
                return counter(2);

            case THREES:
                return counter(3);

            case FOURS:
                return counter(4);

            case FIVES:
                return counter(5);

            case SIXES:
                return counter(6);

            case FULL_HOUSE:
                int sum = 0;
                if (fullHouseChecker()) {
                    for (int i : m_dice) {
                        sum += i;
                    }
                    return sum;
                } else {
                    return 0;
                }

            case FOUR_OF_A_KIND:
                return forOfAKindChecker(bubbleSort());

            case LITTLE_STRAIGHT:

                if (straighChecker(bubbleSort()) && m_dice[0] == 1){
                    return 30;
                } else {
                    return 0;
                }

            case BIG_STRAIGHT:

                if (straighChecker(bubbleSort()) && m_dice[0] == 2){
                    return 30;
                }else {
                    return 0;
                }

            case CHOICE:
                return sumOfDice(m_dice);

        }
        return 0;
    }

    int counter(int countNumber) {

        int counter = 0;

        for (int i = 0; i < m_dice.length; i++) {
            if (m_dice[i] == countNumber) {
                counter += 1;
            }
        }
        return counter * countNumber;

    }

    boolean fullHouseChecker() {

        int counter = 0;

        for (int i = 0; i < m_dice.length; i++) {
            for (int j = 1; j < m_dice.length; j++) {

                if (m_dice[i] == m_dice[j]) {
                    counter += 1;
                }
            }
            if (counter == 3) {
                return true;
            } else if (counter > 3) {
                return false;
            }
            counter = 0;
        }
        return false;
    }

    int[] bubbleSort() {

        int hilf = 0;

        for (int i = 0; i < m_dice.length; i++) {
            for (int j = i+1 ; j < m_dice.length; j++) {
                if (m_dice[i] > m_dice[j]) {
                    hilf = m_dice[i];
                    m_dice[i] = m_dice[j];
                    m_dice[j] = hilf;
                }
            }
        }
        return m_dice;
    }

    int forOfAKindChecker(int[] m_dice) {

        int counter = 0;
        int result = 0;

        for (int i = 0; i < m_dice.length; i++) {
            for (int j = 1; j < m_dice.length; j++) {

                if (m_dice[i] == m_dice[j]) {
                    counter += 1;
                }
            }
            if (counter == 4) {

                result = m_dice[i] * 4;

            }
            counter = 0;
        }
        return result;
    }

    boolean straighChecker(int[] m_dice) {

        for (int i = 0; i < m_dice.length-1; i++){

            if(m_dice[i]+1 != m_dice[i+1]) {
                return false;
            }
        }
        return true;
    }

    int sumOfDice(int[] m_dice){
        int sum = 0;
        for (int i : m_dice){
            sum += i;
        }
        return sum;
    }

}


