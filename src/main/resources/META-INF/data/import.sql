INSERT INTO SimulationFields(name, SA, IRS, SS, TA, BE, varComponent) VALUES("Telemóvel",false,false,false,false,true,false);
INSERT INTO SimulationFields(name, SA, IRS, SS, TA, BE, varComponent) VALUES("Veículo",false,false,false,true,true,false);
INSERT INTO SimulationFields(name, SA, IRS, SS, TA, BE, varComponent) VALUES("Combustível",false,false,false,true,true,false);
INSERT INTO SimulationFields(name, SA, IRS, SS, TA, BE, varComponent) VALUES("Internet Móvel",false,false,false,false,true,false);
INSERT INTO SimulationFields(name, SA, IRS, SS, TA, BE, varComponent) VALUES("Via Verde",false,false,false,true,true,false);
INSERT INTO SimulationFields(name, SA, IRS, SS, TA, BE, varComponent) VALUES("Manutenção de veículo",false,false,false,true,true,false);

INSERT INTO Tax(name, value) VALUES("autonomousTributation", 10);
INSERT INTO Tax(name, value) VALUES("workerSocialSecurity", 11);
INSERT INTO Tax(name, value) VALUES("companySocialSecurity", 23.75);

INSERT INTO Margin(margin_min, margin_max) VALUES (-100, 500);

INSERT INTO WorkInsurance(workInsuranceVariable) VALUES (0.007);

INSERT INTO FoodSubsidy(foodSubsidyMonth) VALUES(160.23);
