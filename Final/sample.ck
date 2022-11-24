P name[parameters]
{

S plain = "The quick red fox jumped over the lazy brown dog";
S cypher = plain>>2; // shift
print[cypher];
S polyalphabet = plain<<"polyalphabet"; // polyalphabetic

print[cypher@]; // String analysis
print[polyalphabet@];

if[plain == deshift[2, cypher]]
{
	print["decyphered"];
}
else
{
	print["bad logic"];
}

I i = 0;
while[i < 10]
{
	print[i];
	i = i + 1;
}

F S deshift[I amount, S cyphertext]
{
	R cyphertext>>26-I;
}

}