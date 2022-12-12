P test[parameters]
{

F S deshift[I amount, S cyphertext]
{
    deshift = cyphertext >> [26 - amount];
};

S plain;
plain = 'The quick red fox jumped over the lazy brown dog';
S cypher;
cypher = plain >> 2; %encyphers the string by shifting by the amount given%
print[cypher];
print['\n'];
S polyalphabet;
polyalphabet = plain << 'polyalphabet'; %encyphers the string based on the key given%


S temp;
temp = cypher @;
print[temp]; %String analysis%
print['\n'];
temp = polyalphabet @;
print[temp];
print['\n'];

S de;
de = 'not set';
de = deshift[2, cypher];
print[de];
print['\n'];
if['yes' == 'yes']
{
	print['string comp works'];
	print['\n'];
}
else
{
	print['bad logic'];
	print['\n'];
};

I i;
i = 0;
while[i < 10]
{
	print[i];
	print['\n'];
	i = i + 1;
};

}