package com.company;

public class Money
{
    /**
     * типы
     */
    public enum MoneyType
    {
        ruble, // ruble
        dollar, // dollar
        euro // euro
    }

    ;

    /**
     * private
     */

    private double value;
    private MoneyType type;

    /**
     * конструктор
     */

    public Money(double value, MoneyType type)
    {
        this.value = value;
        this.type = type;
    }

    @Override
    public String toString()
    {
        String typeAsString = "";
        switch (this.type)
        {
            case ruble:
                typeAsString = "Рубликов";
                break;
            case dollar:
                typeAsString = "ДоллАров";
                break;
            case euro:
                typeAsString = "Еуров";
                break;
        }
        return String.format("%s %s", this.value, typeAsString);
    }

    /**
     * операция сложения с числом
     */
    public Money add(double number)
    {
        Money newMoney = new Money(this.value + number, this.type);
        return newMoney;
    }

    /**
     * операция вычитания числа
     */
    public Money subtract(double number)
    {
        Money newMoney = new Money(this.value - number, this.type);
        return newMoney;
    }

    /**
     * операция умножения на число
     */
    public Money multiply(double number)
    {
        Money newMoney = new Money(this.value * number, this.type);
        return newMoney;
    }

    /**
     * операция деления на число
     */
    public Money divide(double number)
    {
        Money newMoney = new Money(this.value / number, this.type);
        return newMoney;
    }

    public Money to(MoneyType newType)
    {
        double newValue = this.value;

        // если текущий тип - рубли
        if (this.type == MoneyType.ruble)
        {
            // во что преобразовываем
            switch (newType)
            {
                case ruble: // rubli
                    newValue = this.value;
                    break;
                case dollar: // dollari
                    newValue = this.value * 0.013;
                    break;
                case euro: // euro
                    newValue = this.value * 0.011;
                    break;
            }
        } else if (newType == MoneyType.ruble)
        {
            switch (this.type)
            {
                case ruble: // rubli
                    newValue = this.value;
                    break;
                case dollar: // dollari
                    newValue = this.value * 0.013;
                    break;
                case euro: // euro
                    newValue = this.value * 0.011;
                    break;
            }
        } else
        {
            newValue = this.to(MoneyType.ruble).to(newType).value;
        }
        // результат это money
        return new Money(newValue, newType);
    }
}

