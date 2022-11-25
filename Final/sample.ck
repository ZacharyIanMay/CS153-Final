P name[parameters]
{

S plain;
plain = "The quick red fox jumped over the lazy brown dog";
S cypher;
cypher = plain >> 2; %encyphers the string by shifting by the amount given%
print[cypher];
S polyalphabet;
polyalphabet = plain << "polyalphabet"; %encyphers the string based on the key given%

print[cypher @]; %String analysis%
print[polyalphabet @];

if[plain == deshift[2, cypher]]
{
	print["decyphered"];
}
else
{
	print["bad logic"];
}

I i;
i = 0;
while[i < 10]
{
	print[i];
	i = i + 1;
}

F S deshift[I amount, S cyphertext]
{
	R cyphertext >> 26 - amount;
}

}