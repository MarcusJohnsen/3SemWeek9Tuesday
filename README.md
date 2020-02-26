# Tuesday
I have completed the assignment in it's entirety. Below here I will comment on the code.
I have commented on the things in the assignment with the label "understand / explain" in the commit messages.
The one-to-one unidirectional relation adds an address FK to Customer in the DB. It's the same with bidirectional, only address can access customer now as well.
One-to-many unidirectional. At first there was an extra table created to deal with the relation, but after adding the @JoinColumn part it was instead created under the addresses table, with the customer ID set to belong to the address
One-to-many bidirectional. The purpose of the @mappedBy is to be in the parent's side of the relation. It informs JPA not to create an extra relation table, as it is already being mapped by the other side - the ManyToOne side.
Many-to-many creates an extra relational table holding both the cust id and address id, and combines them
Lastly the facade class has been added with all the methods.

# Wednesday
