struct patient{
	int ID;
	int age;
	int severity;
	int priority;
};
void readdetails(struct patient * p);
void display(struct patient * patient);
void prioritydisplay(struct patient * patient);
void prioritycount(struct patient * patient);

