from django.db import models
from calendar import monthrange
import re
import logging
import os
import datetime

class Login(models.Model):

	login = models.CharField(max_length = 100, primary_key = True)
	password = models.CharField(max_length = 100)

class User(models.Model):
	
	rb = models.IntegerField(primary_key = True)
	name = models.CharField(max_length = 40)
	email = models.CharField(max_length = 40, null = True)

class Description(models.Model):

	isbn = models.IntegerField(primary_key = True)
	name = models.CharField(max_length = 100)
	author = models.CharField(max_length = 40)

class Book(models.Model):

	description = models.ForeignKey(Description)
	collection_id = models.IntegerField(primary_key = True)
	status = models.BooleanField(default = False)

class Loan(models.Model):

	user = models.ForeignKey(User)
	book = models.ForeignKey(Book)
	begin = models.DateField(null = True)
	end = models.DateField(null = True)
	received = models.DateField(null = True)
	penalty = models.DecimalField(max_digits = 10, decimal_places = 2, default = 0.0)