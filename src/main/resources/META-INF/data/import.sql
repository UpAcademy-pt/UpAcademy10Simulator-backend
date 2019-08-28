INSERT INTO SimulationFields(name, SA, IRS, SS, TA, BE, varComponent) VALUES("Telemovel",false,false,false,false,true,false);
INSERT INTO SimulationFields(name, SA, IRS, SS, TA, BE, varComponent) VALUES("Veiculo",false,false,false,true,true,false);
INSERT INTO SimulationFields(name, SA, IRS, SS, TA, BE, varComponent) VALUES("Combustivel",false,false,false,true,true,false);
INSERT INTO SimulationFields(name, SA, IRS, SS, TA, BE, varComponent) VALUES("Internet Movel",false,false,false,false,true,false);
INSERT INTO SimulationFields(name, SA, IRS, SS, TA, BE, varComponent) VALUES("Via Verde",false,false,false,true,true,false);
INSERT INTO SimulationFields(name, SA, IRS, SS, TA, BE, varComponent) VALUES("Manutencao de veiculo",false,false,false,true,true,false);
INSERT INTO SimulationFields(name, SA, IRS, SS, TA, BE, varComponent) VALUES("Outros C/ Tributacao Autonoma",false,false,false,true,false,false);
INSERT INTO SimulationFields(name, SA, IRS, SS, TA, BE, varComponent) VALUES("Outros S/ Tributacao Autonoma",false,false,false,false,false,false);



INSERT INTO Tax(name, value) VALUES("autonomousTributation", 10);
INSERT INTO Tax(name, value) VALUES("workerSocialSecurity", 11);
INSERT INTO Tax(name, value) VALUES("companySocialSecurity", 23.75);

INSERT INTO Margin(margin_min, margin_max) VALUES (15, 500);

INSERT INTO WorkInsurance(workInsuranceVariable, varAccountedForWorkInsurance) VALUES (0.007, 14);

INSERT INTO FoodSubsidy(foodSubsidyMonth, averageDaysOfTheMonth, limitValueForFoodSubsidy) VALUES(160.23, 21, 7.63);
