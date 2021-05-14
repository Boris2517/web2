package com.example.fitness.entity;

import javax.persistence.Entity;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

@Entity
@Table(name="admins")
public class Admin extends User{
}
