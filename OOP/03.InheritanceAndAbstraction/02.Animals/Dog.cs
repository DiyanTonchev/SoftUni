﻿using System;

public class Dog : Animal, ISoundProducible
{
    public Dog(string name, int age, string gender) : base(name, age, gender)
    {

    }

    public void ProduceSound()
    {
        Console.WriteLine("Bau");
    }
}
