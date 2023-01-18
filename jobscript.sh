#!/bin/bash
echo "Bienvenido/a al planeta $PLANETA"
if [ "$AGENTE" = "true" ]
then
	echo "Prepárese para la misión agente X, que la fuerza te acompañe."
else
	echo "Disfruta el planeta $PLANETA humano/a $NOMBRE, trata de no morir."
fi
echo "..."
sleep 10
echo "¡Suerte! La necesitarás."

