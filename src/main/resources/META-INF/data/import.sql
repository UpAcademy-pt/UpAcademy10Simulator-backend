INSERT INTO SimulationFields(name, SA, IRS, SS, TA, BE, varComponent) VALUES("baseSalary",false,true,true,false,false,false);
INSERT INTO SimulationFields(name, SA, IRS, SS, TA, BE, varComponent) VALUES("foodSubsidy",true,false,false,false,false,false);
INSERT INTO SimulationFields(name, SA, IRS, SS, TA, BE, varComponent) VALUES("phone",false,false,false,false,true,false);
INSERT INTO SimulationFields(name, SA, IRS, SS, TA, BE, varComponent) VALUES("vehicle",false,false,false,true,true,false);
INSERT INTO SimulationFields(name, SA, IRS, SS, TA, BE, varComponent) VALUES("fuel",false,false,false,true,true,false);
INSERT INTO SimulationFields(name, SA, IRS, SS, TA, BE, varComponent) VALUES("healthInsurance",false,false,false,false,true,false);
INSERT INTO SimulationFields(name, SA, IRS, SS, TA, BE, varComponent) VALUES("workInsurance",false,false,false,false,true,false);
INSERT INTO SimulationFields(name, SA, IRS, SS, TA, BE, varComponent) VALUES("mobileNet",false,false,false,false,true,false);
INSERT INTO SimulationFields(name, SA, IRS, SS, TA, BE, varComponent) VALUES("zPass",false,false,false,true,true,false);
INSERT INTO SimulationFields(name, SA, IRS, SS, TA, BE, varComponent) VALUES("otherWithTA",false,false,false,true,false,false);
INSERT INTO SimulationFields(name, SA, IRS, SS, TA, BE, varComponent) VALUES("vehicleMaintenance",false,false,false,true,true,false);
INSERT INTO SimulationFields(name, SA, IRS, SS, TA, BE, varComponent) VALUES("otherWithoutTA",false,false,false,false,false,false);
INSERT INTO SimulationFields(name, SA, IRS, SS, TA, BE, varComponent) VALUES("otherAwards",false,true,false,false,false,false);

INSERT INTO Tax(name, value) VALUES("autoTaxation", 10);
INSERT INTO Tax(name, value) VALUES("socialSecurityWorker", 11);
INSERT INTO Tax(name, value) VALUES("socialSecurityCompany", 23.75);

